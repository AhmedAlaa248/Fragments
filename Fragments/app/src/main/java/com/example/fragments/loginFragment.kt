package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.commit

class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        var edtName : EditText = view.findViewById(R.id.edt_user_name)
        var btnLogIn : Button = view.findViewById(R.id.bt_login)
        var btnSignUp : Button = view.findViewById(R.id.bt_sign_up)

        //Send data
        var Name : String = edtName?.text.toString()

        var bundle : Bundle = Bundle()
        bundle.putString("user_name", Name)

        btnLogIn.setOnClickListener {
            val hm : HomeFragment = HomeFragment()
            //Send data
            arguments = bundle

            activity?.supportFragmentManager?.commit {

                replace(R.id.container, hm)
                    .addToBackStack(null)
            }

//            activity?.supportFragmentManager?.commit {
//                replace(R.id.container, hm)
//                    .addToBackStack(null)
//
//            }
        }
        btnSignUp.setOnClickListener {
            val su = SignupFragment()
            // We can hide , show ,Add , replace
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, su)
                //?.addToBackStack(null)
                ?.commit()

        }

        return view
    }

}
