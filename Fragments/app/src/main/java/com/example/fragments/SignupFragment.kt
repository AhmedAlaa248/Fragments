package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.commit

class SignupFragment : Fragment() {

    var edtName: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        var btnCreate: Button = view.findViewById(R.id.btn_createAccount)
        edtName = view.findViewById(R.id.edt_name)

        var Name : String = edtName?.text.toString()

        var bundle : Bundle = Bundle()
        bundle.putString("user_name",Name)

        btnCreate.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                val hm: HomeFragment = HomeFragment()
                hm.arguments = bundle
                replace(R.id.container, hm)
                addToBackStack(null)
            }
        }



        return view
    }
}