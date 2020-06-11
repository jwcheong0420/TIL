package main

import (
	mongo "other/mongo/db"
	mysql "other/mysql/db"
)

func main() {
	mondb := mongo.Get()
	mydb := mysql.Get()
}
