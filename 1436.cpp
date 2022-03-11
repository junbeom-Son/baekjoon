#include <iostream>

using namespace std;

bool findTitle(int num) {
	int count = 0;
	int result;
	while (num > 0) {
		result = num % 10;
		if (result == 6) {
			count++;
			if (count == 3) return true;
		}
		else count = 0;
		num /= 10;
	}
	if (count >= 3) return true;
	else return false;
}

int main() {
	int n, result;
	int count = 0;
	bool possibleTitle = false;
	cin >> n;
	for (int i = 0;; i++) {
		possibleTitle = findTitle(i);
		if (possibleTitle) {
			count++;
			if (count == n) {
				result = i;
				break;
			}
		}
	}
	cout << result << endl;


	return 0;
}