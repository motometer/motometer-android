package ua.com.motometer.android.ui.garage


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.garage_item.view.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.garage.GarageListFragment.OnListFragmentInteractionListener

class GarageListRecyclerViewAdapter(
        private val mValues: List<Vehicle>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<GarageListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Vehicle
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.garage_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.displayName.text = item.displayName()
        holder.buildYear.text = item.builtYear().toString()

        with(holder.view) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val displayName: TextView = view.display_name
        val buildYear: TextView = view.built_year
        val icon: ImageView = view.list_icon

        override fun toString(): String {
            return super.toString() + " '" + displayName.text + "'"
        }
    }
}
