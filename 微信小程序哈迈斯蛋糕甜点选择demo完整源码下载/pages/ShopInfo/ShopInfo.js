//获取应用实例
var app = getApp()
Page({
  data: {
    shop: {
      name: '小酒窝',
      icon: '/image/dimple.png',
      desc: '甜品店',
      purchaseNote: "采用蓝风车、安佳淡奶油，口感香醇香醇不腻，水果选用当季新鲜水果，五任何添加剂，订蛋糕需提前预定，在造型上尽可能的满足客人的需求，支持各种定制！\n 杭州主城区5km内免费配送\n新鲜/健康/定做\n实打实的最好每一个蛋糕收餐时，请检查物品完好。千万记住哦！收到后请冰箱冷藏保存！另外满意请帮忙返图发朋友圈宣传宣传哦！不满意也要提出您宝贵的建议！如有需要请加微信联系！\n 微信号：18767165234",
      phoneNum1: 18767165234,
      phoneNum2: 18814809028,  
      wechat: 18767165234,
      alipay: "1242410586@qq.com"
    },
    
  },  
  showAddress: function() {
    wx.openLocation({
      latitude: 22.805700,
      longitude: 113.864300,
      name: '小酒窝私家烘焙',
      address: "浙江省杭州市西湖区"
    })
  },
  dialPhone: function(event) {
    wx.makePhoneCall({
      phoneNumber: event.currentTarget.dataset.phone,
    })
  },
  onLoad: function () {
    console.log('onLoad')    
  },
  onShareAppMessage: function () {
    return {
      title: '小酒窝',
      desc: '甜品店',
      path: 'pages/ShopInfo/ShopInfo'
    }
  },
  previewImage: function (e) {
    var current = e.target.dataset.src;
    wx.previewImage({
      current: current,
      urls: [current]
    })
    wx.getImageInfo({// 获取图片信息（此处可不要）
      src: current,
      success: function (res) {
        console.log(res.width)
        console.log(res.height)
      }
    })

   
  }
})
