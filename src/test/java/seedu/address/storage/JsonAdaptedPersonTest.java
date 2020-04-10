package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_CAP;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DESCRIPTION;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DP;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GITHUB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_MAJOR;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TIME;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_UNIVERSITY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CAP_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DP_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FROM_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GITHUB_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TO_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_UNIVERSITY_AMY;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.item.field.Description;
import seedu.address.model.item.field.DisplayPicture;
import seedu.address.model.item.field.Email;
import seedu.address.model.item.field.Github;
import seedu.address.model.item.field.Major;
import seedu.address.model.item.field.Name;
import seedu.address.model.item.field.Phone;
import seedu.address.model.item.field.Time;
import seedu.address.model.item.field.University;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalPerson;

public class JsonAdaptedPersonTest {
    @Test
    public void toModelType_validPerson_returnsPerson() throws IllegalValueException {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(new PersonBuilder(TypicalPerson.AMY).build());
        assertEquals(new PersonBuilder(TypicalPerson.AMY).build(), jsonAdaptedPerson.toModelType());

        jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY, VALID_PHONE_AMY,
                VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY, VALID_FROM_AMY, VALID_TO_AMY,
                VALID_CAP_AMY);
        assertEquals(new PersonBuilder(TypicalPerson.AMY).build(), jsonAdaptedPerson.toModelType());
    }

    @Test
    public void toModelType_missingDisplayPicture_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(null, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, DisplayPicture.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidDisplayPicture_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(INVALID_DP, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                DisplayPicture.MESSAGE_CONSTRAINTS_FILE_TYPE,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingName_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, null, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, INVALID_NAME, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Name.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingDescription_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, null,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidDescription_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, INVALID_DESCRIPTION,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Description.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingPhone_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                null , VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                INVALID_PHONE, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Phone.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingEmail_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, null, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, INVALID_EMAIL, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Email.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingGithub_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, null, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Github.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidGithub_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, INVALID_GITHUB, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Github.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingUniversity_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_PHONE_AMY, null, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, University.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidUniversity_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, INVALID_UNIVERSITY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                University.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingMajor_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_PHONE_AMY, VALID_UNIVERSITY_AMY, null,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Major.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidMajor_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, INVALID_MAJOR,
                VALID_FROM_AMY, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Major.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingFrom_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_PHONE_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                null, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Time.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidFrom_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                INVALID_TIME, VALID_TO_AMY, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Time.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_missingTo_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_PHONE_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, null, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                String.format(MISSING_FIELD_MESSAGE_FORMAT, Time.class.getSimpleName()),
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidTo_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, INVALID_TIME, VALID_CAP_AMY);
        assertThrows(IllegalValueException.class,
                Time.MESSAGE_CONSTRAINTS,
                jsonAdaptedPerson::toModelType);
    }

    // TODO: Integrate the following two tests with Duong's CAP PR
    @Test
    public void toModelType_missingCap_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_PHONE_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, null);
        assertThrows(IllegalValueException.class, // parseDouble(null) results in NPE
                "The cap field must be a numeric value",
                jsonAdaptedPerson::toModelType);
    }

    @Test
    public void toModelType_invalidCap_throwsIllegalValueException() {
        JsonAdaptedPerson jsonAdaptedPerson = new JsonAdaptedPerson(VALID_DP_AMY, VALID_NAME_AMY, VALID_DESCRIPTION_AMY,
                VALID_PHONE_AMY, VALID_EMAIL_AMY, VALID_GITHUB_AMY, VALID_UNIVERSITY_AMY, VALID_MAJOR_AMY,
                VALID_FROM_AMY, VALID_TO_AMY, INVALID_CAP);
        assertThrows(IllegalValueException.class,
                "The cap value must be between 0.0 and 5.0 inclusive.",
                jsonAdaptedPerson::toModelType);
    }
}
