import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    void clear() {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Error! Resume with ID = " + r.uuid + " already exist!");
                return;
            }
        }
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        System.out.println("Warning! Resume with ID = " + uuid + " doest't exist.");
        return null;
    }

    void delete(String uuid) {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[storageSize -1];
                storage[storageSize-1] = null;
                return;
            }
        }
        System.out.println("Warning! Resume with ID = " + uuid + " doest't exist.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int sizeCounter = 0;
        for (Resume aStorage : storage) {
            if (aStorage != null) sizeCounter++;
        }
        return sizeCounter;
    }
}
