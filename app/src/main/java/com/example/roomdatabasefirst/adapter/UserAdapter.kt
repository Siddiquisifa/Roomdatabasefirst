package com.example.roomdatabasefirst.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasefirst.UserActivity
import com.example.roomdatabasefirst.database.entity.User
import com.example.roomdatabasefirst.databinding.UserLayoutBinding


class UserAdapter(val context: Context, var uList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UserLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var user = uList[position]

        holder.binding.tvName.text = "${user.name}"
        holder.binding.tvEmail.text = "${user.email}"
        holder.binding.tvContact.text = "${user.contact}"
        holder.binding.tvId.text = "${user.id}"

       /* holder.binding.parentCard.setOnClickListener {
            var intent = Intent(context, UserActivity::class.java)
            intent.putExtra("USER", user)
            context.startActivity(intent)
        }*/


    }

    override fun getItemCount(): Int = uList.size

    fun setItems(userList:MutableList<User>)
    {
        this.uList = userList
        notifyDataSetChanged()      // refresh recyclerview list item
    }
}