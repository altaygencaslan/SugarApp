package com.sugarapp.examle.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import com.sugarapp.examle.R
import com.sugarapp.examle.jobsmodel.Jobs
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class JobsAdapter(_context: Context, _listOfJobs: ArrayList<Jobs>) : BaseAdapter() {
    var context: Context = _context
    var listOfJobs: ArrayList<Jobs> = _listOfJobs

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView2 : View
        if (convertView == null) {
            convertView2 = View.inflate(context, R.layout.display_job, null)

            var job:Jobs = listOfJobs[position]
            var txtJobTitleView: TextView = convertView2.findViewById<TextView>(R.id.txtJobTitleView)
            txtJobTitleView.setText(job.JobName)

            return convertView2;
        }

        return convertView
    }

    override fun getItem(position: Int): Any {
        return listOfJobs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listOfJobs.size
    }

}