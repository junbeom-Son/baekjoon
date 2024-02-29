#include <iostream>
using namespace std;
int main() {
	int t, messageLength;
	char content;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> messageLength >> content;
		for (int j = 0; j < messageLength; j++) {
			cout << content;
		}
		cout << endl;
	}
	return 0;
}