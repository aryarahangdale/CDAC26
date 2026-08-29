#include <iostream>
using namespace std;

// V1: Original bug — Call by Value (does NOT work)
void resetSensorPairV1(int reading1, int reading2) {
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
    // Note: Changes are local to this function only
}

// V2: Fix 1 — Call by Reference (WORKS)
void resetSensorPairV2(int& reading1, int& reading2) {
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}

// V3: Fix 2 — Call by Pointer (WORKS)
void resetSensorPairV3(int* reading1, int* reading2) {
    int temp = *reading1;
    *reading1 = *reading2;
    *reading2 = temp;
}

int main() {
    int A, B;

    // Test V1: Call by Value
    cout << "--- V1: Call by Value ---" << endl;
    A = 55;
    B = 12;
    cout << "Before : A=" << A << " B=" << B << endl;
    resetSensorPairV1(A, B);
    cout << "After : A=" << A << " B=" << B << " ← values unchanged" << endl;

    // Explanation for why V1 fails
    /*
     * WHY V1 FAILS:
     * When a function is called by value, the parameters (reading1, reading2) are
     * copies of the original variables (A, B). Any changes made inside the function
     * only affect these local copies, not the original variables in main().
     * Once the function returns, the copies are destroyed and the original A and B
     * remain unchanged. This is called "Call by Value" semantics.
     */

    // Test V2: Call by Reference
    cout << "\n--- V2: Call by Reference ---" << endl;
    A = 55;
    B = 12;
    cout << "Before : A=" << A << " B=" << B << endl;
    resetSensorPairV2(A, B);
    cout << "After : A=" << A << " B=" << B << " ← values swapped" << endl;

    // Test V3: Call by Pointer
    cout << "\n--- V3: Call by Pointer ---" << endl;
    A = 12;
    B = 55;
    cout << "Before : A=" << A << " B=" << B << endl;
    resetSensorPairV3(&A, &B);
    cout << "After : A=" << A << " B=" << B << " ← values swapped back" << endl;

    return 0;
}
