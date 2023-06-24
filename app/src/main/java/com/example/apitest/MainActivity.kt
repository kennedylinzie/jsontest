package com.example.apitest

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.example.apitest.data.UserDataEntity
import com.example.apitest.ui.viewDetail
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.ui.MainAdapter
import com.example.apitest.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : AppCompatActivity(),MainAdapter.OnItemClickListener {

    private val viewModel: MainViewModel by viewModels()

    lateinit var bind: ActivityMainBinding


    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)


        val mainAdapter = MainAdapter()
        mainAdapter.setOnItemClickListener(this)
        mediaPlayer = MediaPlayer()
     //   val messageEntity = UserDataEntity(20,"dkslskjlfkl","kennedy","linzie",22222,0)


        bind.recyclerView.apply {
            adapter = mainAdapter
        }

//                viewModel.viewModelScope.launch {
//            viewModel.upsert(messageEntity)
//        }

        viewModel.viewModelScope.launch {
            viewModel.query.collect(){
                mainAdapter.submitList(it.map {
                    it
                }
            )
        }
    }
    }

    override fun onItemClick(userData: UserDataEntity) {

        val intent = Intent(this, viewDetail::class.java)
        intent.putExtra("avatarUrl", userData.avatarUrl)
        intent.putExtra("eventsUrl", userData.eventsUrl)
        intent.putExtra("followersUrl", userData.followersUrl)
        intent.putExtra("followingUrl", userData.followingUrl)
        intent.putExtra("gistsUrl", userData.gistsUrl)
        intent.putExtra("gravatarId", userData.gravatarId)
        intent.putExtra("htmlUrl", userData.htmlUrl)
        intent.putExtra("id", userData.id)
        intent.putExtra("login", userData.login)
        intent.putExtra("nodeId", userData.nodeId)
        intent.putExtra("organizationsUrl", userData.organizationsUrl)
        intent.putExtra("receivedEventsUrl", userData.receivedEventsUrl)
        intent.putExtra("reposUrl", userData.reposUrl)
        intent.putExtra("siteAdmin", userData.siteAdmin)
        intent.putExtra("starredUrl", userData.starredUrl)
        intent.putExtra("subscriptionsUrl", userData.subscriptionsUrl)
        intent.putExtra("type", userData.type)
        intent.putExtra("url", userData.url)
        startActivity(intent)

    }


}