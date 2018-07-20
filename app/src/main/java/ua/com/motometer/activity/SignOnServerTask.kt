package ua.com.motometer.activity

import android.os.AsyncTask
import org.apache.http.NameValuePair
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import java.io.IOException

class SignOnServerTask : AsyncTask<String, Unit, String>() {

    override fun doInBackground(vararg params: String?): String {
        val httpClient = DefaultHttpClient()
        val httpPost = HttpPost("http://134.249.122.222:8080/login/google/${params[0]}")

        try {
            val nameValuePairs: ArrayList<NameValuePair> = ArrayList(1)
            nameValuePairs.add(BasicNameValuePair("idToken", params[0]))
            httpPost.setEntity(UrlEncodedFormEntity(nameValuePairs))

            val response = httpClient.execute(httpPost)
            val statusCode = response.getStatusLine().getStatusCode()
            val responseBody = EntityUtils.toString(response.getEntity())

            return "succes"
        } catch (e: ClientProtocolException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
        return "fail"
    }
}