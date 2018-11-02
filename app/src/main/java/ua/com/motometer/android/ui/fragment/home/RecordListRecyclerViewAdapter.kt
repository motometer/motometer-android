package ua.com.motometer.android.ui.fragment.home


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_recordlist.view.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord
import ua.com.motometer.android.ui.state.api.ActionListener
import ua.com.motometer.android.ui.state.api.Actions

class RecordListRecyclerViewAdapter(
        private val mValues: List<ExpenseRecord>,
        private val actionListener: ActionListener?)
    : RecyclerView.Adapter<RecordListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ExpenseRecord
            actionListener?.onAction(Actions.Home.TrackRecordDetails(item.id()))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_recordlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id().toString()
        holder.mContentView.text = with(item) {
            return@with "${amount()} $ | ${description()} |${date()}"
        }

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
