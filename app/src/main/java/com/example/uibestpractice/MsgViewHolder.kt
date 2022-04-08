package com.example.uibestpractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

sealed class MsgViewHolder(view:View) : RecyclerView.ViewHolder(view) //密封类

class LeftViewHolder(view: View) : MsgViewHolder(view){
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view){
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}