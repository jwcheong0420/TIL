class Parent(object):		# object can be skipped
	def methodA(self):
		return 'methodA'

class Child(Parent):		# class Child inherits class Parent
	def methodB(self):
		return 'methodB'

parent = Parent()
print(parent, parent.methodA())

child = Child()
print(child, child.methodA())
print(child, child.methodB())