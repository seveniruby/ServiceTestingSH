import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void getInstance() {
        assertNotNull(Config.getInstance().token);
    }
}