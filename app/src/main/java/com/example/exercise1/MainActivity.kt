package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.set
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val car_price = editTextCarPrice.text.toString().toInt()
            if(car_price <= 0) {
                editTextCarPrice.setError("Please enter the correct car price !!!")
            }
            val downpayment = editTextDownPayment.text.toString().toInt()
            if(downpayment <= (car_price/10)){
                editTextDownPayment.setError("Down payment must be 10% of car price")
            }
            val loan_peroid = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()

            //TODO() : Continue your calculation here :^ />
            //TODO() : Find the locale of the user and display the currently sign
            val loan = car_price - downpayment
            textViewLoan.text = getString(R.string.loan) + "${loan}" //loan.toString()
            val interest = loan * interest_rate * loan_peroid
            textViewInterest.text = getString(R.string.interest) + interest.toString()
            val monthlyPayment = (loan + interest)/loan_peroid/(12)
            textViewMonthly.text = getString(R.string.monthly_repayment) + monthlyPayment.toString()


        }
    }

    fun resetInput(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
        textViewInterest.text = getString(R.string.interest)
        textViewLoan.text = getString(R.string.loan)
        textViewMonthly.text = getString(R.string.monthly_repayment)
    }
}
