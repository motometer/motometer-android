package ua.com.motometer.android.ui.fragment.garage


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.garage_item.view.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.model.Vehicle
import ua.com.motometer.android.ui.state.api.ActionListener

class ListRecyclerViewAdapter(private val listener: ActionListener)
    : ListAdapter<Vehicle, ListRecyclerViewAdapter.ViewHolder>(VehicleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.garage_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Vehicle) {
            with(view) {
                display_name.text = "${item.manufacturer()} ${item.model()}"
                built_year.text = item.builtYear().toString()
                setOnClickListener(VehicleOnClickListener(listener))
                tag = item
            }
        }
    }
}

private class VehicleDiffCallback : DiffUtil.ItemCallback<Vehicle>() {
    override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean =
            oldItem.id() == newItem.id()

    override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean =
            oldItem == newItem
}
