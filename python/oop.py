# method : 객체 안에서 사용되는 function
# field : 객체 안의 variable

# class
class Cal(object):
	# constructor
	def __init__(self, v1, v2):		# first param of method must be instance itself
		print(v1, v2)
		self.v1 = v1
		self.v2 = v2

	# methods
	def add(self):
		return self.v1 + self.v2
	def subtract(self):
		return self.v1 - self.v2


c1 = Cal(10, 10)		# create Cal instance
print(c1.add())			# use add() method in c1 instance
print(c1.subtract())	# use subtract() method in c1 instance

c2 = Cal(30, 20)
print(c2.add())
print(c2.subtract())