package com.sugarapp.examle.jobsmodel

import com.orm.SugarRecord
import com.orm.dsl.Column
import com.orm.dsl.Table

@Table(name = "jobs")
class Jobs : SugarRecord() {

    @Column(name = "job_name")
    var JobName:String = ""

    @Column(name = "job_description")
    var JobDescription:String = ""
}