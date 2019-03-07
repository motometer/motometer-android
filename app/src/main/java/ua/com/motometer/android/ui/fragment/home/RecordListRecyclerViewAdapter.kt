package ua.com.motometer.android.ui.fragment.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recordlist.view.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord

class RecordListRecyclerViewAdapter
    : ListAdapter<ExpenseRecord, RecordListRecyclerViewAdapter.ViewHolder>(Diff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_recordlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.mIdView.text = item.date().toString()
        holder.mContentView.text = with(item) {
            return@with "${amount()} $ | ${description()} |${date()}"
        }

        with(holder.view) {
            tag = item
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val mIdView: TextView = view.item_number
        val mContentView: TextView = view.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}

private class Diff : DiffUtil.ItemCallback<ExpenseRecord>() {
    override fun areItemsTheSame(oldItem: ExpenseRecord, newItem: ExpenseRecord): Boolean =
            oldItem == newItem

    override fun areContentsTheSame(oldItem: ExpenseRecord, newItem: ExpenseRecord): Boolean =
            oldItem == newItem
}