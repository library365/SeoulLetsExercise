package com.whalez.reservationlive.ui.service_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whalez.reservationlive.R
import com.whalez.reservationlive.ui.service_list.filtered_services.AreaFilteredActivity
import com.whalez.reservationlive.util.isDoubleClicked
import kotlinx.android.synthetic.main.area_item.view.*

class AreaAdapter(private val context: Context, private val codeName: String): RecyclerView.Adapter<AreaAdapter.GuViewHolder>() {

    private val areaList: List<String> = arrayListOf(
        "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구",
        "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구",
        "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.area_item, parent, false)
        return GuViewHolder(view)
    }

    override fun getItemCount(): Int = areaList.size

    override fun onBindViewHolder(holder: GuViewHolder, position: Int) {
        holder.bind(areaList[position])
    }

    inner class GuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(areaName: String){
            itemView.tv_gu.text = areaName

            itemView.setOnClickListener {

                if(isDoubleClicked()) return@setOnClickListener

                val intent = Intent(context, AreaFilteredActivity::class.java)
                intent.putExtra("areaName", areaName)
                intent.putExtra("codeName", codeName)
                context.startActivity(intent)
            }
        }
    }
}