package jp.making.felix.readrecorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_read_data_regist.*

class BookRegist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_regist)
        val editText = findViewById<EditText>(R.id.bookName)
        submitButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            if(editText.text.isNotEmpty()){
                val api = CallApi()
                api.call(editText.text.toString())
                Thread.sleep(1000)
                startActivity(intent)
            }

        }
    }
}
