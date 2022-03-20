#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int get_avg(vector<int> numbers) 
{
    int result;
    double sum = 0;
    for (size_t i = 0; i < numbers.size(); i++) 
    {
        sum += numbers[i];
    }
    sum = round(sum / numbers.size());
    result = (int)sum;
    return result;
}

int get_mode(vector<int> numbers) 
{
    int orderIndex = 0, modeIndex = 0, maxFrequent = 0, answer = 0;
    vector<int> count, sortedCount;
    count.push_back(1);
    for (size_t i = 1; i < numbers.size(); i++)
    {
        if (numbers[i] == numbers[i - 1])
        {
            count[orderIndex]++;
        }
        else
        {
            count.push_back(1);
            orderIndex++;
        }
    }
    if (count.size() == 1) return numbers[0];
    sortedCount = count;
    sort(sortedCount.begin(), sortedCount.end());
    reverse(sortedCount.begin(), sortedCount.end());
    maxFrequent = sortedCount[0];
    if (sortedCount[0] == sortedCount[1])
    {
        int second = 0;
        for (size_t i = 0; i < count.size(); i++)
        {
            if (count[i] == maxFrequent)
            {
                second++;
                if (second == 2)
                {
                    modeIndex = i;
                    break;
                }
            }
        }
    }
    else
    {
        for (size_t i = 0; i < count.size(); i++)
        {
            if (count[i] == maxFrequent)
            {
                modeIndex = i;
                break;
            }
        }
    }
    orderIndex = 0;
    for (size_t i = 1; i < numbers.size(); i++)
    {
        if (numbers[i] != numbers[i - 1])
        {
            orderIndex++;
            if (orderIndex == modeIndex)
            {
                answer = i;
                break;
            }
        }
    }
    return numbers[answer];
}

int main()
{
    int n, avg, median, mode, range, num;
    cin >> n;
    vector<int> numbers;
    for (int i = 0; i < n; i++) {
        cin >> num;
        numbers.push_back(num);
    }
    sort(numbers.begin(), numbers.end());
    avg = get_avg(numbers);
    median = numbers[n / 2];
    mode = get_mode(numbers);
    range = numbers[n - 1] - numbers[0];
    cout << avg << endl;
    cout << median << endl;
    cout << mode << endl;
    cout << range << endl;
    return 0;
}