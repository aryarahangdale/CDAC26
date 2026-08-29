#include <iostream>
#include <bitset>
using namespace std;

int main() {
    int statusReg = 0b10110001;      // Read-only from firmware side
    int controlReg = 0b00000000;     // Firmware writes here
    int dataReg = 0b11001010;        // For reassignment demo

    cout << "=== Register Access Demo ===" << endl;

    // regPtr1: const int* — Data is const, pointer is mutable
    cout << "\n--- regPtr1 (const int*) ---" << endl;
    const int* regPtr1 = &statusReg;
    cout << "Status Register Value: " << bitset<8>(*regPtr1) << " (" << *regPtr1 << ")" << endl;
    
    // Attempt to write through const pointer (INVALID - commented out)
    // *regPtr1 = 0b11111111;  // ERROR: assignment of read-only location
    cout << "// *regPtr1 = 0b11111111;  [ERROR: Cannot write to const data]" << endl;
    
    // Attempt to repoint (VALID - const int* allows pointer reassignment)
    regPtr1 = &controlReg;  // This is allowed
    cout << "// regPtr1 = &controlReg;  [VALID: Can repoint const int*]" << endl;

    // regPtr2: int* const — Data is mutable, pointer is const
    cout << "\n--- regPtr2 (int* const) ---" << endl;
    int* const regPtr2 = &controlReg;
    cout << "Control Register Before: " << bitset<8>(*regPtr2) << " (" << *regPtr2 << ")" << endl;
    
    // Write new value (VALID - int* const allows data modification)
    *regPtr2 = 0b10101010;
    cout << "Control Register After: " << bitset<8>(*regPtr2) << " (" << *regPtr2 << ")" << endl;
    
    // Attempt to repoint (INVALID - commented out)
    // regPtr2 = &dataReg;  // ERROR: assignment of read-only variable
    cout << "// regPtr2 = &dataReg;  [ERROR: Cannot repoint int* const]" << endl;

    // regPtr3: const int* const — Both data and pointer are const
    cout << "\n--- regPtr3 (const int* const) ---" << endl;
    const int* const regPtr3 = &statusReg;
    cout << "Status Register Value: " << bitset<8>(*regPtr3) << " (" << *regPtr3 << ")" << endl;
    
    // Attempt to write (INVALID - commented out)
    // *regPtr3 = 0b11111111;  // ERROR: assignment of read-only location
    cout << "// *regPtr3 = 0b11111111;  [ERROR: Cannot write to const data]" << endl;
    
    // Attempt to repoint (INVALID - commented out)
    // regPtr3 = &dataReg;  // ERROR: assignment of read-only variable
    cout << "// regPtr3 = &dataReg;  [ERROR: Cannot repoint const pointer]" << endl;

    cout << "\n=== Summary ===" << endl;
    cout << "const int*       : Can repoint, CANNOT write data" << endl;
    cout << "int* const       : CANNOT repoint, can write data" << endl;
    cout << "const int* const : CANNOT repoint, CANNOT write data" << endl;

    return 0;
}
