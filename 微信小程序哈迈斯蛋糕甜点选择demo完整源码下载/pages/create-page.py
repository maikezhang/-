#!/usr/bin/env python
# -*- coding: utf-8 -*-	

import shutil
import os

# 输入名称创建Page, 直接回车退出
while True:
	des = raw_input("Page Name: ")
	if des:
		os.makedirs(des)

		shutil.copyfile("index-template/index.js", des + "/" + des + ".js")
		shutil.copyfile("index-template/index.json", des + "/" + des + ".json")
		shutil.copyfile("index-template/index.wxml", des + "/" + des + ".wxml")
		shutil.copyfile("index-template/index.wxss", des + "/" + des + ".wxss")

		print("page created, name: " + des)
	else:
		break

print("exit")
