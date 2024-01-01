#!/bin/bash
#author:peak

#alias pgit

# 检查是否存在.git目录
if [ ! -d "./.git" ]; then
  echo "错误：不是一个git仓库"
  exit 1
fi

# 添加所有修改的文件
git add .

# 提交更改
#read -p "请输入提交消息: " message
message=${message:-'update'}
git commit -m "$message"

# 推送到远程仓库
git push origin main

echo "一键git完成"


