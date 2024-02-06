#include <iostream>

using namespace std;

int arr[301][301];
void rotateArr(int top, int left, int bottom, int right) {
	if (top >= bottom || left >= right) {
		return;
	}
	int curBuffer = arr[bottom][left];
	int lastBuffer = arr[top][left];
	for (int i = bottom; i > top + 1; --i) {
		arr[i][left] = arr[i - 1][left];
	}
	arr[top + 1][left] = lastBuffer;
	lastBuffer = curBuffer;
	curBuffer = arr[bottom][right];
	for (int i = right; i > left + 1; --i) {
		arr[bottom][i] = arr[bottom][i - 1];
	}
	arr[bottom][left + 1] = lastBuffer;
	lastBuffer = curBuffer;
	curBuffer = arr[top][right];
	for (int i = top; i < bottom - 1; ++i) {
		arr[i][right] = arr[i + 1][right];
	}
	arr[bottom - 1][right] = lastBuffer;
	lastBuffer = curBuffer;
	for (int i = left; i < right - 1; ++i) {
		arr[top][i] = arr[top][i + 1];
	}
	arr[top][right - 1] = lastBuffer;
	rotateArr(top + 1, left + 1, bottom - 1, right - 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, r;
	cin >> n >> m >> r;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			cin >> arr[i][j];
		}
	}
	while (r > 0) {
		rotateArr(1, 1, n, m);
		--r;
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}