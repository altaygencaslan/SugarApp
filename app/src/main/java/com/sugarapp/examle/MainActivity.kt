package com.sugarapp.examle

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.orm.SugarRecord
import com.sugarapp.examle.adapter.JobsAdapter
import com.sugarapp.examle.jobsmodel.Jobs
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.insert_job.*

class MainActivity : AppCompatActivity() {

    lateinit var arraylistofJobs: ArrayList<Jobs>
    lateinit var jobsAdater:JobsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arraylistofJobs = ArrayList<Jobs>()
        var listJobs: List<Jobs> = SugarRecord.listAll(Jobs::class.java)

        for (j in listJobs) {
            arraylistofJobs.add(j)
        }

        var lvMain : ListView = findViewById<ListView>(R.id.lvMain)
        jobsAdater = JobsAdapter(this, arraylistofJobs)
        lvMain.adapter = jobsAdater
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.mnMain -> {
                val dialog: Dialog = Dialog(this)
                dialog.setContentView(R.layout.activity_main)
                dialog.setTitle("Main")
                dialog.show()
            }

            R.id.mnNew -> {
                val dialog: Dialog = Dialog(this)
                dialog.setContentView(R.layout.insert_job)
                dialog.setTitle("Add New")
                dialog.btnSave.setOnClickListener {
                    var job:Jobs= Jobs()
                    job.JobName = dialog.txtJobName.text.toString()
                    job.JobDescription = dialog.txtJobDescription.text.toString()
                    job.save()

                    arraylistofJobs.add(job)
                    lvMain.adapter = jobsAdater
                    jobsAdater.notifyDataSetChanged()

                    dialog.hide()

                    Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show()

                }
                dialog.show()
            }
        }


        return super.onOptionsItemSelected(item)
    }
}
