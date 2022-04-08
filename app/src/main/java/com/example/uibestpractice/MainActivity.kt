package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()

    private lateinit var adapter : MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        val send:Button = findViewById(R.id.send)
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val send:Button = findViewById(R.id.send)
        val inputText:TextView = findViewById(R.id.inputText)
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        when(v){
            send ->{
                val content = inputText.text.toString()
                if (content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1)//当有新消息时
                    //刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size - 1)//将RecyclerView定位到最后一行
                    inputText.setText("")//清空输入框的内容
                }
            }
        }
    }

    private fun initMsg(){
        val msg1 = Msg("Hello guy.",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello who is that?",Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}