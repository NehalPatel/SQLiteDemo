package com.example.sqlitedemo.helpers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sqlitedemo.R

class StudentAdapter(context: Context, private val studentList: List<Student>) :
    ArrayAdapter<Student>(context, R.layout.item_student, studentList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val student = studentList[position]

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.item_student, parent, false)

        val nameTextView = rowView.findViewById<TextView>(R.id.tvStudentName)
        val emailTextView = rowView.findViewById<TextView>(R.id.tvEmail)
        val phoneTextView = rowView.findViewById<TextView>(R.id.tvPhoneNumber)

        nameTextView.text = student.name
        emailTextView.text = student.email
        phoneTextView.text = student.phoneNumber

        return rowView
    }
}