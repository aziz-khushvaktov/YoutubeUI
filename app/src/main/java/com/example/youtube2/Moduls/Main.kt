package com.example.youtube2.Moduls

class Main(var iv_video: String, var iv_mainProfile: Int,var shorts: ArrayList<Shorts>?) {
    @JvmName("getSubShorts1")
    fun getSubShorts(): ArrayList<Shorts>? {
        return shorts
    }
    @JvmName("setSubShorts1")
    fun setSubShorts(subShorts: ArrayList<Shorts>?){
        this.shorts = subShorts
    }
}