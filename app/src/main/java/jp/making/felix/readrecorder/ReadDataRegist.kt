package jp.making.felix.readrecorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_read_data_regist.*

class ReadDataRegist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_data_regist)
        val titleText = findViewById<TextView>(R.id.titleText)
        val intent =intent
        val bookId = intent.getStringExtra("bookId")
        titleText.text = "何ページまで読んだかを入力してください。"
        val rcon = RealmController()
        var lastPage = 0
        bookId?.apply {
            rcon.findData(bookId)?.pages?.last()?.apply {
                lastPage = this.pageData
            }

        }
        submitButton.setOnClickListener{view ->
            val intentSub = Intent(this,BookDataView::class.java)
            val pages = findViewById<EditText>(R.id.pageValue)
            val pageValue = pages.getText().toString().toInt()
            if(pageValue >= lastPage) {
                rcon.updateData(bookId, pageValue)
                intentSub.putExtra("bookId", bookId)
                startActivity(intentSub)
            }
        }

    }
}
