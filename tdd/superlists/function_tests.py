import unittest
from selenium import webdriver

# Functional Test == Acceptance(합격) Test == End-to-End Test

class NewVisitorTest(unittest.TestCase): # tests are organised into classes, which inherit from 'unittest.TestCase'
	# 'Test Fixture'
	def setUp(self):		# 'setUp' is special method which get run before each test
		self.browser = webdriver.Chrome('chromedriver')
		self.browser.implicitly_wait(10)	# 'implicitly_wait(n)' waits n seconds to load HTML element
	def tearDown(self):		# 'tearDown' is special method which get run after each test
		self.browser.quit()

	# 'Test Case'
	# : 'Test Runner' runs methods that start with 'test_' by ascending order
	def test_visitPageAndAddSchedule(self):
		## Edith has heard about a cool new online to-do app
		## She goes to check out its homepage
		self.browser.get('http://localhost:8000')

		## She notices the page title and header mention to-do lists
		self.assertIn('To-Do', self.browser.title)	# 'assertIn(a, b)' makes assertions when a is not in b
		self.fail('Finish the test!')	# 'fail()' just fails no matter what

		## She is invited to enter a to-do item straight away
		## and so on ...

# 'unittest.main()' launches the unittest 'Test Runner'
if __name__ == '__main__':
	unittest.main(warnings = 'ignore')		# 'warnings = \'ignore\'' avoids printing too many warning messages
