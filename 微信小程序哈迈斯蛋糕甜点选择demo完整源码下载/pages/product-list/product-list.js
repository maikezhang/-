//获取应用实例
import PRODUCT from "../../data.js"
var app = getApp()
Page({
  data: {
    products: PRODUCT, 
    scrollH: 0,
    imgWidth: 0,
    loadingCount: 0,
    images: [],
    col1: [],
    col2: []   
  },  
  onLoad: function () {
    wx.getSystemInfo({
      success: (res) => {
        let ww = res.windowWidth;
        let wh = res.windowHeight;
        let imgWidth = ww * 0.48;
        let scrollH = wh;

        this.setData({
          scrollH: scrollH,
          imgWidth: imgWidth
        });

       
      }
    }) 
      
  },
  showImg: function(event) {
    console.log('showImg:' + event.currentTarget.dataset.img)    
    wx.navigateTo({
      url: '../show-img/show-img?img=' + event.currentTarget.dataset.img + '&name=' + event.currentTarget.dataset.name
    })
    // wx.previewImage({
    //   current: '',
    //   urls: [event.currentTarget.dataset.img],
    //   success: function(res) {},
    //   fail: function(res) {},
    //   complete: function(res) {},
    // })
  },
  onShareAppMessage: function () {
    return {
      title: '哈麦斯面包店',
      desc: '一个面包店',
      path: 'pages/product-list/product-list'
    }
  },
  onPullDownRefresh:function(){
    console.info("下拉刷新了");
  }

})
