package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
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
}
