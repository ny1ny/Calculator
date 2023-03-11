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
    lateinit var btnZer: Button
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
    lateinit var per:Button
    lateinit var tvPreView: TextView
    lateinit var tvResult: TextView

  //  var operand1: Int = -1
   // var operand2: Int = -1
    var operator: String = ""
    var preViewStr: String = ""
    var calculatedValue: Float = 0.0F
    var realValueS :String = ""
    var realValue2:String=""

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
         btnZer = findViewById<Button>(R.id.btn_num_0)
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
        per = findViewById(R.id.btn_per)


        initListeners()

    }

    private fun initListeners() {
        binding.btnNum0.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("0")

        }

        binding.btnPer.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignOperator("%")



        }
        btnOne.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("1")
        }
        binding.btnNum2.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("2")
        }
        btnThree.setOnClickListener {
            // TODO: this code will be execute when use click on it

            assignValue("3")
        }
        btnFour.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("4")
        }
        btnFive.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("5")
        }
        btnSix.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("6")
        }
        btnSeven.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("7")
        }
        btnEight.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("8")
            continue1()
        }
        btnNine.setOnClickListener {
            // TODO: this code will be execute when use click on it
            assignValue("9")
            continue1()
        }
        btnDot.setOnClickListener {
assignValue(".")

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
            realValueS=calculatedValue.toString()
            operator=""
            realValue2=""
            tvPreView.text=calculatedValue.toString()
            preViewStr=calculatedValue.toString()
            Log.e(TAG, "assignValue: realvalueS : $realValueS",)

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
                calculatedValue = realValueS.toFloat() + realValue2.toFloat()
            }
            "-" -> {
                calculatedValue = realValueS.toFloat() - realValue2.toFloat()
            }
            "*" -> {
                calculatedValue = realValueS.toFloat() * realValue2.toFloat()
            }
            "/" -> {
                calculatedValue = realValueS.toFloat() / realValue2.toFloat()
            }
            "%" -> {
                calculatedValue=realValueS.toFloat() / 100
            }
        }
    }
    private fun assignValue(value: String) {
        if( operator.isEmpty()) {


                realValueS = "$realValueS$value"
                preViewStr = "$preViewStr $value"

        }
         else {
            //  realValue2 = value
            // preViewStr = "$preViewStr $realValue2"

//                 realValue2 = realValue2+value
//                 preViewStr = "$preViewStr $value"
            realValue2 = "$realValue2$value"
            preViewStr = "$preViewStr $value"
        }
            Log.e(TAG, "assignValue: realvalueS : $realValueS",)
          //  Log.e(TAG, "assignoperator: operatot : $operator",)
            Log.e(TAG, "assignValue: realValue2 : $realValue2",)


        tvPreView.text = preViewStr
    }
    private fun assignOperator(operator: String) {
        this.operator = operator
        preViewStr = "$preViewStr $operator"
        Log.e(TAG, "assignOperator: operator : $operator", )
        tvPreView.text = preViewStr
    }

    private fun delete() {

            if (realValue2 != "") {
                realValue2 = realValue2.substring(0, realValue2.length - 1)
                preViewStr = "$realValueS $operator $realValue2"
            }
            else if (operator.isNotEmpty()) {
                operator=""
                preViewStr = "$realValueS"

            //$operator"// $realValue2"
            }
            //  preViewStr = "$realValueS $operator $realValue2"


//        else if(operator.isNotEmpty()) {
//            operator = ""
//            preViewStr = "$operand1"
//        }

        else if(realValueS != "")
        {
            realValueS = realValueS.substring(0,realValueS.length - 1)

            preViewStr = "$realValueS "
        }
        else
            {

            }
        tvPreView.text = preViewStr

        Log.e(TAG, "delete: realValueS : $realValueS", )
        Log.e(TAG, "delete: realValue2 : $realValue2", )
        Log.e(TAG, "delete: operator : $operator", )
    }

    private fun allClear() {

        realValueS="0"
        realValue2="0"
        operator = ""
        calculatedValue = 0.0F
        preViewStr = ""

        tvPreView.text = ""
        tvResult.text = ""

        """
            previewStr  = 1
            previewStr  = 1 * 
            previewStr  = 1 * 5 9 
        """.trimIndent()
    }
  private  fun continue1() {
       if(realValue2!="") {
           calculatedValue

       }
    }


    companion object {
        const val TAG = "MainActivity"
    }


}