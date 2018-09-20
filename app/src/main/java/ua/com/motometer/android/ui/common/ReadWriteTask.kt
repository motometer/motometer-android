package ua.com.motometer.android.ui.common

import android.os.AsyncTask

class ReadWriteTask<T>(
        private val supplier: () -> T,
        private val consumer: (T) -> Unit
) : AsyncTask<Unit, Unit, T>() {

    override fun doInBackground(vararg params: Unit?): T = supplier.invoke()

    override fun onPostExecute(result: T) = consumer.invoke(result)
}