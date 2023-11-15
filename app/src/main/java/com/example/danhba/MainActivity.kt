package com.example.danhba

import User
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.danhba.MyAdapter
//import com.example.danhba.ui.theme.PhoneBookTheme
import java.util.*
import android.view.*

val userList = listOf(
    User(1, "An ", "123-456-789001", "an@gmail.com"),
    User(2, "Anh", "123-456-789002", "anh@gmail.com"),
    User(3, "Ánh", "123-456-789003", "anh1@gmail.com"),
    User(4, "Bảo", "123-456-789004", "bao@gmail.com"),
    User(5, "Bách", "123-456-789005", "bach@gmail.com"),
    User(6, "Cảnh", "123-456-789006", "canh@gmail.com"),
    User(7, "Chinh", "123-456-789007", "chinh@gmail.com"),
    User(8, "Hoàng", "123-456-789008", "hoang@gmail.com"),
    User(9, "Huy", "123-456-789009", "huy@gmail.com"),
    User(10, "Khánh", "123-456-789010", "khanh@gmail.com"),
    User(11, "Lâm", "123-456-789011", "lam@gmail.com"),
    User(12, "Linh", "123-456-789012", "linh@gmail.com"),
    User(13, "Long", "123-456-789013", "long@gmail.com"),
    User(14, "Minh", "123-456-789014", "minh@gmail.com"),
    User(15, "Nam", "123-456-789015", "nam@gmail.com"),
    User(16, "Phong", "123-456-789016", "phong@gmail.com"),
    User(17, "Thịnh", "123-456-789017", "thinh@gmail.com"),
    User(18, "Thiện", "123-456-789018", "thien@gmail.com"),
    User(19, "Tuấn", "123-456-789019", "tuan@gmail.com"),
    User(20, "Trang", "123-456-789020", "trang@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}