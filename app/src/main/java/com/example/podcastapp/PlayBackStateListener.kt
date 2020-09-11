package com.example.podcastapp

import android.util.Log
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player

class PlaybackStateListener : Player.EventListener {
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        var stateString = "";
        when (playbackState) {
            ExoPlayer.STATE_IDLE -> stateString = "ExoPlayer.STATE_IDLE      -"
            ExoPlayer.STATE_BUFFERING -> stateString = "ExoPlayer.STATE_BUFFERING -"
            ExoPlayer.STATE_READY -> stateString = "ExoPlayer.STATE_READY     -"
            ExoPlayer.STATE_ENDED -> stateString = "ExoPlayer.STATE_ENED"
            else -> stateString = "UNKNOWN_STATE"
        }
        Log.d(
            "stateChange", "changed state to " + stateString
                    + " playWhenReady: " + playWhenReady
        );
    }

    override fun onIsPlayingChanged(isPlaying: Boolean) {
        super.onIsPlayingChanged(isPlaying)
        if (isPlaying) {
            Log.d("isPlaying", isPlaying.toString())
        }
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        super.onPlayerError(error)
        Log.d("error",error.message.toString())
    }
}