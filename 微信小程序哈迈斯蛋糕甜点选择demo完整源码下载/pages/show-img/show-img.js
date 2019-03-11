//获取应用实例
var app = getApp()
Page({
  data: {
    img: '',    
  },  
  onLoad: function (option) {

    console.log('onLoad: ' + option.img)
    wx.setNavigationBarTitle({
      title: option.name
    })
    this.setData({
      img: option.img
    })
  }
})
