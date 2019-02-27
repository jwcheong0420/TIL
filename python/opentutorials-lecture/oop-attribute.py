
# attribute : member variable of instance. ex) c1.v1

class C:
	def __init__(self, v):
		self.__value = v
	def show(self):
		print(self.__value)

c1 = C(10)
c1.show()
# print(c1.__value)		# AttributeError: 'C' object has no attribute '__value'
						# act like private member variable