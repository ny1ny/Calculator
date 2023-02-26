package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var btnZero: Button
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnOprPlus: Button
    lateinit var btnOprMinus: Button
    lateinit var btnOprMultiply: Button
    lateinit var btnOprDivide: Button
    lateinit var btnDot: Button
    lateinit var btnResult: Button
    lateinit var btnAllClear: Button
    lateinit var btnDel: Button
    lateinit var tvPreView: TextView
    lateinit var tvResult: TextView

    var operand1: Int = -1
    var operand2: Int = -1
    var operator: String = ""
    var preViewStr: String = ""
    var calculatedValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
         btnOne = findViewById<Button>(R.id.btn_num_1)
         btnTwo = findViewById<Button>(R.id.btn_num_2)
         btnThree = findViewById<Button>(R.id.btn_num_3)
         btnFour = findViewById<Button>(R.id.btn_num_4)
         btnFive = findViewById<Button>(R.id.btn_num_5)
         btnSix = findViewById<Button>(R.id.btn_num_6)
         btnSeven = findViewById<Button>(R.id.btn_num_7)
         btnEight = findViewById<Button>(R.id.btn_num_8)
         btnNine = findViewById<Button>(R.id.btn_num_9)
         btnZero = findViewById<Button>(R.id.btn_num_0)
         btnOprPlus = findViewById<Button>(R.id.btn_opr_plus)
         btnOprMinus = findViewById<Button>(R.id.btn_opr_minus)
        btnOprMultiply = findViewById<Button>(R.id.btn_opr_multiply)
        btnOprDivide = findViewById<Button>(R.id.btn_opr_divide)
        btnResult = findViewById<Button>(R.id.btn_result)
        btnDel = findViewById<Button>(R.id.btn_del)
        btnAllClear = findViewById<Button>(R.id.btn_ac)
        tvPreView = findViewById<Button>(R.id.tv_preView)
        tvResult = findViewById<Button>(R.id.tv_result)
        btnDot = findViewById<Button>(R.id.btn_num_dot)



        initListeners()

    }

    private fun initListeners() {
        binding.btnNum0.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(0)

        }
        btnOne.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(1)
        }
        btnTwo.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(2)
        }
        btnThree.setOnClickListener {
            // TODO: this code will be execute when use click on it

            assignValue(3)
        }
        btnFour.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(4)
        }
        btnFive.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(5)
        }
        btnSix.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(6)
        }
        btnSeven.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(7)
        }
        btnEight.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(8)
        }
        btnNine.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue(9)
        }
        btnDot.setOnClickListener {
            // TODO: dot will be implemented in next phase

        }
        btnOprPlus.setOnClickListener {
           assignOperator("+")
        }
        btnOprMinus.setOnClickListener {
            assignOperator("-")
        }
        btnOprMultiply.setOnClickListener {
            assignOperator("*")
        }

        btnOprDivide.setOnClickListener {
            assignOperator("/")
        }

        btnResult.setOnClickListener {
           calculateResult()
            tvResult.text = calculatedValue.toString()
        }

        btnDel.setOnClickListener {
            delete()
        }
        btnAllClear.setOnClickListener {
           allClear()
        }
    }

    private fun calculateResult() {
        when(operator) {
            "+" -> {
                calculatedValue = operand1 + operand2
            }
            "-" -> {
                calculatedValue = operand1 - operand2
            }
            "*" -> {
                calculatedValue = operand1 * operand2
            }
            "/" -> {
                calculatedValue = operand1 / operand2
            }
        }
    }

    private fun assignValue(value: Int) {
        if(operand1 == -1 && operand2 == -1) {
            operand1 = value
            preViewStr = "$preViewStr $operand1"
        } else {
            operand2 = value
            preViewStr = "$preViewStr $operand2"
        }
        Log.e(TAG, "assignValue: operand1 : $operand1", )
        Log.e(TAG, "assignValue: operand2 : $operand2", )
        tvPreView.text = preViewStr
    }

    private fun assignOperator(operator: String) {
        this.operator = operator
        preViewStr = "$preViewStr $operator"
        Log.e(TAG, "assignOperator: operator : $operator", )
        tvPreView.text = preViewStr
    }

    private fun delete() {
        if(operand2 != -1) {
            operand2 = -1
            preViewStr = "$operand1 $operator"
        } else if(operator.isNotEmpty()) {
            operator = ""
            preViewStr = "$operand1"
        } else if(operand1 != -1) {
            operand1 = -1
            preViewStr = ""
        }
        tvPreView.text = preViewStr
        Log.e(TAG, "delete: operand1 : $operand1", )
        Log.e(TAG, "delete: operand2 : $operand2", )
        Log.e(TAG, "delete: operator : $operator", )
    }

    private fun allClear() {
        operand1 = -1
        operand2 = -1
        operator = ""
        calculatedValue = 0
        preViewStr = ""

        tvPreView.text = ""
        tvResult.text = ""

        """
            previewStr  = 1
            previewStr  = 1 * 
            previewStr  = 1 * 5 9 
        """.trimIndent()
    }

    companion object {
        const val TAG = "MainActivity"
    }


}