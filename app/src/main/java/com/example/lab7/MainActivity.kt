package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val studentList : ArrayList<Student> = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter=StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager=LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator=DefaultItemAnimator()
    }
    fun addStudent(v: View){
        val mDialogView :View = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog : AlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener{
        studentList.add(Student(mDialogView.edt_id.text.toString(), mDialogView.edt_name.text.toString(),mDialogView.edt_age.text.toString().toInt()))
        recycler_view.adapter?.notifyDataSetChanged()
        Toast.makeText(applicationContext,"The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData(){
        studentList.add(Student("601234567-8","Student 1", 20))
        studentList.add(Student("601234567-8","Student 2", 21))
    }
}
