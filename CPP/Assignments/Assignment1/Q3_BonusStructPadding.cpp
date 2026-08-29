#include <iostream>
using namespace std;

struct Layout1 { 
    char c1;      // 1 byte + 3 bytes padding
    int i;        // 4 bytes
    char c2;      // 1 byte + 3 bytes padding
};

struct Layout2 { 
    int i;        // 4 bytes
    char c1;      // 1 byte + 1 byte padding
    char c2;      // 1 byte + 2 bytes padding
};

int main() {
    cout << "=== STRUCT PADDING ANALYSIS ===" << endl;
    cout << "\nLayout1: char c1, int i, char c2" << endl;
    cout << "  sizeof(Layout1) = " << sizeof(Layout1) << " bytes" << endl;

    cout << "\nLayout2: int i, char c1, char c2" << endl;
    cout << "  sizeof(Layout2) = " << sizeof(Layout2) << " bytes" << endl;

    cout << "\n=== EXPLANATION ===" << endl;

    cout << "\n1. WHY THE SIZES DIFFER:" << endl;
    cout << "   Layout1 = 12 bytes (char + padding + int + char + padding)" << endl;
    cout << "   Layout2 = 8 bytes (int + char + char + padding)" << endl;
    cout << "   The different member order results in different padding requirements." << endl;

    cout << "\n2. WHAT IS PADDING AND WHY IS IT ADDED?" << endl;
    cout << "   Padding: Empty bytes inserted between struct members to maintain alignment." << endl;
    cout << "   " << endl;
    cout << "   Why? CPU hardware accesses memory most efficiently when data is aligned to" << endl;
    cout << "   its natural boundaries:" << endl;
    cout << "   - char:   1-byte alignment (can start at any address)" << endl;
    cout << "   - int:    4-byte alignment (must start at addresses 0,4,8,12,...)" << endl;
    cout << "   - double: 8-byte alignment (must start at addresses 0,8,16,...)" << endl;
    cout << "   " << endl;
    cout << "   If an int is placed at an unaligned address (e.g., address 5), the CPU" << endl;
    cout << "   may require 2 memory reads instead of 1, significantly slowing down access." << endl;

    cout << "\n3. HOW LAYOUT1 CAUSES PADDING:" << endl;
    cout << "   Address 0-0:    char c1        [1 byte used, 3 bytes wasted for int alignment]" << endl;
    cout << "   Address 4-7:    int i          [4 bytes]" << endl;
    cout << "   Address 8-8:    char c2        [1 byte used, 3 bytes wasted for struct alignment]" << endl;
    cout << "   Total: 12 bytes (3 + 4 + 1 = 8 bytes data, 4 bytes padding)" << endl;

    cout << "\n4. HOW LAYOUT2 AVOIDS EXCESSIVE PADDING:" << endl;
    cout << "   Address 0-3:    int i          [4 bytes]" << endl;
    cout << "   Address 4-4:    char c1        [1 byte]" << endl;
    cout << "   Address 5-5:    char c2        [1 byte]" << endl;
    cout << "   Address 6-7:    (padding)      [2 bytes for struct alignment]" << endl;
    cout << "   Total: 8 bytes (6 bytes data, 2 bytes padding)" << endl;

    cout << "\n5. WHY MEMBER ORDER MATTERS FOR NETWORK & HARDWARE:" << endl;
    cout << "   Network Protocol Headers:" << endl;
    cout << "   - Packets sent over network must have predictable byte layout" << endl;
    cout << "   - Receiver expects exact byte sequence; unexpected padding breaks protocol" << endl;
    cout << "   - Example: TCP header must be exactly 20 bytes (without options)" << endl;
    cout << "   " << endl;
    cout << "   Hardware Register Maps:" << endl;
    cout << "   - Embedded firmware reads/writes to memory-mapped I/O registers" << endl;
    cout << "   - Datasheet specifies exact addresses (0x1000, 0x1004, 0x1008, etc.)" << endl;
    cout << "   - Struct padding can place data at wrong addresses, breaking hardware access" << endl;
    cout << "   " << endl;
    cout << "   Solution:" << endl;
    cout << "   - Use #pragma pack(1) to disable padding" << endl;
    cout << "   - Manually arrange members to minimize padding" << endl;
    cout << "   - Always verify sizeof() matches protocol/hardware spec" << endl;

    cout << "\n=== PRACTICAL EXAMPLE ===" << endl;

    struct NetworkPacket {
        char version;           // Must be at offset 0
        int timestamp;          // Must be at offset 4 (per protocol)
        char status;            // Must be at offset 8
    };

    cout << "\nNetworkPacket struct (unsafe - has padding):" << endl;
    cout << "  sizeof(NetworkPacket) = " << sizeof(NetworkPacket) << endl;
    cout << "  If protocol expects 9 bytes, this 12-byte struct will fail!" << endl;

    return 0;
}
