package com.example.sqlitedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.sqlitedemo.helpers.StudentAdapter
import com.example.sqlitedemo.helpers.StudentDatabaseHelper

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: StudentDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load student data from the database
        loadStudentData()
    }

    private fun loadStudentData(){

        databaseHelper = StudentDatabaseHelper(this)

//        val studentListView = findViewById<ListView>(R.id.studentListView)
        val studentListView = findViewById<View>(R.id.studentListView)

        val studentList = databaseHelper.getAllStudents()

        val adapter = StudentAdapter(this, studentList)
        //studentListView.adapter = adapter
    }

    fun addNewStudent(view: View) {
        val name = findViewById<EditText>(R.id.etStudentName).text.toString()
        val email = findViewById<EditText>(R.id.etStudentEmail).text.toString()
        val phoneNumber = findViewById<EditText>(R.id.etPhoneNumber).text.toString()

        databaseHelper.addStudent(name, email, phoneNumber)

        Toast.makeText(this, "Student added!", Toast.LENGTH_SHORT).show()

    }
}