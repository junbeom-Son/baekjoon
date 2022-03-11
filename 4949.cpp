#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{
    string line;
    bool pair;
    char lastOpened;
    while (true) {
        pair = true;
        getline(cin, line);
        stack<char> openBrackets;
        if (line == ".") break;
        for (int i = 0; i < (int)line.size(); i++) {
            if (line[i] == '(') openBrackets.push('(');
            else if (line[i] == '[') openBrackets.push('[');
            else if (line[i] == ')') {
                if (openBrackets.empty()) {
                    pair = false;
                    break;
                }
                lastOpened = openBrackets.top();
                openBrackets.pop();
                if (lastOpened == '[') {
                    pair = false;
                    break;
                }
            }
            else if (line[i] == ']') {
                if (openBrackets.empty()) {
                    pair = false;
                    break;
                }
                lastOpened = openBrackets.top();
                openBrackets.pop();
                if (lastOpened == '(') {
                    pair = false;
                    break;
                }
            }
        }
        if (!openBrackets.empty()) pair = false;
        if (pair) cout << "yes" << endl;
        else cout << "no" << endl;
    }
    return 0;
}