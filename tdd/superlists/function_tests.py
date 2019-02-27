import unittest
from selenium import webdriver

class NewVisitorTest(unittest.TestCase):
	def setUp(self):
		self.browser = webdriver.Chrome('chromedriver')

	def tearDown(self):
		self.browser.quit()

	def test_visitPageAndAddSchedule(self):
		# 사용자 A가 일정 입력 홈페이지에 방문한다
		self.browser.get('http://localhost:8000')

		# 홈페이지 타이틀이 'Scheduler'임을 확인하고 제대로 방문한 것을 확인한다
		self.assertIn('일정관리', self.browser.title)
		self.fail('테스트 종료')

		# 일정 입력 페이지로 이동한다

		# A는 텍스트 박스에 'TDD 공부하기'를 입력한다

		# A가 엔터를 누르면 페이지 새로고침 -> 일정 목록 보여준다

		# '1: TDD 공부하기'가 첫 번째 할 일로 일정 목록에 뜬다

		# A가 텍스트박스에 추가로 'python 공부하기'를 입력한다

		# 페이지 새로고침 -> 일정 목록에 두 개가 뜸

		# A 자러감

if __name__ == '__main__':
	unittest.main(warnings = 'ignore')