An android library that encapsulates the common pattern involved in activity and fragment communications

The idea is the following
- Avoid activities to implement multiple callback interfaces that fragment's implementation might require
- Communication between fragment and activity becomes event based
- Let the message bus handle asynchronous communication between fragment and activity


Included SampleApp in the repository explains the ideas mentioned in much more clearer way
