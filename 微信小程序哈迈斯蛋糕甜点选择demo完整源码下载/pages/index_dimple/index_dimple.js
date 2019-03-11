// pages/index_dimple.js
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    winHeight: "",//窗口高度
    currentTab: 0, //预设当前项的值
    scrollLeft: 0, //tab标题的滚动条位置
    expertList: [{ //假数据
      img: "avatar.png",
      name: "欢顔",
      tag: "知名情感博主",
      answer: 134,
      listen: 2234
    }],
    scrollH: 0,
    imgWidth: 0,
    loadingCount: 0,
    images: [],
    col1: [],
    col2: [],

    tabDatas:[
      {
        id:0,
        name:"inns风"
      },
      {
        id: 1,
        name: "缤纷水果"
      },
      {
        id: 2,
        name: "甜品"
      }, {
        id: 3,
        name: "卡通"
      }
    ],
    itemArray:[
      0,1,2,3
    ],
    items: [
      {
        name:"爱科长",
        filePathCover:"2.jpg",
        price:12

      }
    ]
    

  },
  showImg: function (event) {
    // debugger;
    console.log('showImg:' + event)
    wx.navigateTo({
      url: '../show-img/show-img?img=' + event.currentTarget.dataset.img + '&name=' + event.currentTarget.dataset.name
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.info("onLoad1");
    
    var that = this;
    //  高度自适应
    wx.getSystemInfo({
      success: function (res) {
        var clientHeight = res.windowHeight,
          clientWidth = res.windowWidth,
          rpxR = 750 / clientWidth;
        var calc = clientHeight * rpxR - 180;
        // console.log(calc)
        that.setData({
          winHeight: calc+90
        });
      }
    });
    // var that = this;
    wx.request({
     
      url: 'https://www.pangirl.xyz/product/typeList',
      success:function(res){
        console.info(res.data);
        that.setData({
          tabDatas:res.data.res
        })
      }
    });

    wx.request({
      url: 'https://www.pangirl.xyz/product/productList?type=0',
      success: function (res) {
        console.info(res.data.res);
        that.setData({
          items: res.data.res,
        });

      }
    });


  
  },
  swichNav:function(e){
    var that=this;
    that.setData({
      items: []
    });
    var cur = e.target.dataset.current;
    if (this.data.currentTaB == cur) { return false; }
    else {
      wx.request({
        url: 'https://www.pangirl.xyz/product/productList?type='+cur,
        success: function (res) {
          console.info(res.data.res);
          that.setData({
            items: res.data.res,
          });

        }
      });
      this.setData({
        currentTab:cur,
      });


        
      
     
    }
  },
  //判断当前滚动超过一屏时，设置tab标题滚动条。
  checkCor: function () {
    if (this.data.currentTab > 4) {
      this.setData({
        scrollLeft: 300
      })
    } else {
      this.setData({
        scrollLeft: 0
      })
    }
  },

  switchTab: function (e) {
    var that=this;
    this.setData({
      currentTab: e.detail.current,
      items: []
    });
    wx.request({
      url: 'https://www.pangirl.xyz/product/productList?type=' + e.detail.current,
      success: function (res) {
        console.info(res.data.res);
        that.setData({
          items: res.data.res,
        });

      }
    });
    this.checkCor();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    console.info("onReady");

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.info("onShow");
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})