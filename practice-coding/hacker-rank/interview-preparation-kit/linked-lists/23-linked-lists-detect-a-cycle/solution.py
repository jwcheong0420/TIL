"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as: 
 
    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""


def has_cycle(head):
    visited_list = dict()
    current = head
    while current:
        if current in visited_list:
            return True
        else:
            visited_list[current] = True
            current = current.next

    return False