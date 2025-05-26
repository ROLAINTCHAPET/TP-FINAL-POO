package Test;



import com.example.events.jsonmanipulation.OrganisateurSerialisation;
import com.example.events.personnes.Organisateur;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrganisateurSerialisationTest {

    private OrganisateurSerialisation serialisation;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Crée un fichier temporaire pour les tests
        tempFile = File.createTempFile("testOrganisateurs", ".json");
        tempFile.deleteOnExit();

        // Remplace le chemin du fichier dans l'instance testée
        serialisation = new OrganisateurSerialisation() {
            {
                this.filePath = tempFile.getAbsolutePath();
                this.file = new File(filePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                objectMapper.writeValue(file, new Organisateur[0]);
            }
        };
    }

    @Test
    void testAddAndGetOrganisateur() throws IOException {
        Organisateur org = new Organisateur("1", "Alice", "alice@event.com", "pass123");
        serialisation.addOrganisateur(org);

        List<Organisateur> result = serialisation.getAllOrganisateur();
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getNom());
    }

    @Test
    void testUpdateOrganisateur() throws IOException {
        Organisateur org = new Organisateur("2", "Bob", "bob@event.com", "bobpass");
        serialisation.addOrganisateur(org);

        Organisateur updated = new Organisateur("2", "Bobby", "bobby@event.com", "newpass");
        serialisation.updateOrganisateur(updated);

        List<Organisateur> result = serialisation.getAllOrganisateur();
        assertEquals(1, result.size());
        assertEquals("Bobby", result.get(0).getNom());
    }

    @Test
    void testDeleteOrganisateur() throws IOException {
        Organisateur org = new Organisateur("3", "Charlie", "charlie@event.com", "charliepass");
        serialisation.addOrganisateur(org);

        serialisation.deleteOrganisateur(org);
        List<Organisateur> result = serialisation.getAllOrganisateur();
        assertTrue(result.isEmpty());
    }

    @Test
    void testRechercherParMotDePasse() throws IOException {
        Organisateur org = new Organisateur("4", "Diana", "diana@event.com", "secret");
        serialisation.addOrganisateur(org);

        Organisateur result = serialisation.rechercherParMotDePasse("secret");
        assertNotNull(result);
        assertEquals("Diana", result.getNom());
    }

    @AfterEach
    void tearDown() {
        tempFile.delete();
    }
}

